/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : persist
 *
 * Copyright Administrateur,  All Rights Reserved.
 *
 * This software is the confidential and proprietary
 * information of Administrateur.
 * You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms
 * of the license agreement you entered into with
 * Administrateur.
 *-------------------------------------------------------- 
 * 
 * Fichier 		:	PersonDaoImpl.java
 * Cree le 		: 	4 sept. 2016 à 13:52:06
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.org.dao.PersonDao;
import com.org.entity.PersonEntity;
import com.org.exception.IllegalArgumentsException;
import com.org.exception.PersonRuntimeException;
import com.org.model.PersonModel;
import com.org.model.TransactionAttributes;
import com.org.utils.DefaultOrder;

/**
 * A Renseigner.
 * @author  : mmenhour
 * @project : persist
 * @package : com.org.dao.impl
 * @date    : 4 sept. 2016 13:52:06
 */
@Repository("personDao")
public class PersonDaoImpl implements PersonDao
{
   @PersistenceContext(unitName = "test")
   private EntityManager em;
   
   public boolean isValidEmailAddress( String email )
   {
      String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
      java.util.regex.Pattern p = java.util.regex.Pattern.compile( ePattern );
      java.util.regex.Matcher m = p.matcher( email );
      return m.matches();
   }
   
   /**
    * 
    * @param email
    * @return
    */
   public List<PersonModel> personsByEmail( String email )
   {
      if( email == null || email.trim().length() == 0 )
      {
         throw new IllegalArgumentsException( "Invalid email " + email );
      }
      if( !isValidEmailAddress( email ) )
      {
         throw new IllegalArgumentsException( "Invalid email expression " + email );
      }
      Query query = em.createNamedQuery( "personByEmail" ).setParameter( "email", email );
      @SuppressWarnings("unchecked")
      List<PersonModel> results = query.getResultList();
      return results;
   }
   
   /**
    * 
    * @see com.org.dao.PersonDao#getPersons()
    */
   @Override
   public List<PersonModel> getPersons() throws PersonRuntimeException
   {
      try
      {
         String quer = "select p from Person p";
         TypedQuery<PersonEntity> query = em.createQuery( quer, PersonEntity.class );
         List<PersonEntity> entities = query.getResultList();
         List<PersonModel> converted = toModel( entities );
         Collections.sort( converted, new DefaultOrder() );
         return converted;
      }
      catch( PersistenceException ex )
      {
         throw new PersonRuntimeException( "Persistence exception detected", ex );
      }
   }
   
   /**
    * 
    * @see com.org.dao.PersonDao#update(com.org.model.PersonModel)
    */
   @Override
   @Transactional(TransactionAttributes.TEST_TX_MANAGER_NAME)
   public PersonModel update( PersonModel personModel ) throws PersonRuntimeException
   {
      
      if( personModel == null )
      {
         throw new NullPointerException();
      }
      if( personModel.getId() == null || personModel.getId() <= 0 )
      {
         throw new IllegalArgumentsException( "Invalid control id <= 0 or null" + personModel.getId() );
      }
      try
      {
         if( read( personModel.getId().intValue() ) == null )
         {
            throw new PersonRuntimeException( "Persistence exception detected during the update of the object PersonModel the id = " + personModel.getId() + "does not exist in database" );
         }
         PersonEntity entity = toEntity( personModel );
         em.merge( entity );
         return toModel( entity );
      }
      catch( PersistenceException ex )
      {
         throw new PersonRuntimeException( "Persistence exception detected during the update of the object PersonModel ", ex );
      }
   }
   
   /**
    * 
    * @see com.org.dao.PersonDao#create(com.org.model.PersonModel)
    */
   @Override
   @Transactional(TransactionAttributes.TEST_TX_MANAGER_NAME)
   public PersonModel create( PersonModel personModel ) throws PersonRuntimeException
   {
      if( personModel == null )
      {
         throw new NullPointerException();
      }
      List<PersonModel> list = personsByEmail( personModel.getEmail() );
      if( list != null && list.size() > 0 )
      {
         throw new PersonRuntimeException( "duplicate email in data base" );
      }
      try
      {
         PersonEntity entity = toEntity( personModel );
         em.persist( entity );
         return toModel( entity );
      }
      catch( PersistenceException ex )
      {
         throw new PersonRuntimeException( "Persistence exception detected during the create of the object PersonModel ", ex );
      }
   }
   
   /**
    * 
    * @see com.org.dao.PersonDao#read(int)
    */
   @Override
   public PersonModel read( Integer id ) throws PersonRuntimeException
   {
      if( id == null || id.intValue() <= 0 )
      {
         throw new IllegalArgumentsException( "Invalid control id <= 0 " + id );
      }
      try
      {
         String quer = "select d from Person d where d.id = :id ";
         TypedQuery<PersonEntity> query = em.createQuery( quer, PersonEntity.class );
         /**
          * TypedQuery<PersonModelEntity> query = em.createNamedQuery(
          * "PersonModelById", PersonModelEntity.class);
          */
         query.setParameter( "id", id );
         PersonEntity entity = query.getSingleResult();
         PersonModel converted = toModel( entity );
         return converted;
      }
      catch( PersistenceException ex )
      {
         throw new PersonRuntimeException( "Persistence exception detected during the read of the object PersonModel id = " + id, ex );
      }
   }
   
   /**
    * 
    * converts and returns a list of object type Person from an object
    * type and PersonEntity
    * 
    * @param entities
    *            list&lt;PersonEntity&gt;
    * @return list&lt;Person&gt;
    */
   private List<PersonModel> toModel( List<PersonEntity> entities )
   {
      if( entities == null || entities.isEmpty() )
      {
         return Collections.emptyList();
      }
      List<PersonModel> Persons = new ArrayList<PersonModel>();
      for( PersonEntity entity : entities )
      {
         Persons.add( toModel( entity ) );
      }
      return Persons;
   }
   
   /**
    * converts and returns an object of type Person from an entity type
    * PersonEntity
    * 
    * @param entity
    *            entities PersonEntity
    * @return Person
    */
   private PersonModel toModel( PersonEntity entity )
   {
      PersonModel personModel = null;
      if( personModel == null )
      {
         personModel = new PersonModel();
      }
      personModel.setEmail( entity.getEmail() );
      personModel.setFirstName( entity.getFirstName() );
      personModel.setId( entity.getId() );
      personModel.setLastName( entity.getLastName() );
      return personModel;
   }
   
   /**
    * converts and returns an entity of type PersonEntity from an
    * object type Person
    * 
    * @param Object
    *            Person
    * @return entity PersonEntity
    */
   private PersonEntity toEntity( PersonModel personModel )
   {
      PersonEntity entity = null;
      if( personModel != null )
      {
         entity = new PersonEntity();
      }
      entity.setEmail( personModel.getEmail() );
      entity.setFirstName( personModel.getFirstName() );
      if( personModel.getId() != null && personModel.getId().intValue() > 0 )
      {
         entity.setId( personModel.getId() );
      }
      entity.setLastName( personModel.getLastName() );
      return entity;
   }
}
