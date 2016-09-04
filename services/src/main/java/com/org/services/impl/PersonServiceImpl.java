/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : services
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
 * Fichier 		:	PersonServiceImpl.java
 * Cree le 		: 	4 sept. 2016 à 14:18:48
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.services.impl;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dao.PersonDao;
import com.org.exception.IllegalArgumentsException;
import com.org.exception.PersonRuntimeException;
import com.org.model.PersonModel;
import com.org.services.PersonService;

/**
 * A Renseigner.
 * @author  : mmenhour
 * @project : services
 * @package : com.org.services.impl
 * @date    : 4 sept. 2016 14:18:48
 */
@Service("personService")
public class PersonServiceImpl implements PersonService
{
   @Autowired
   private PersonDao personDao;
   
   /**
    * @see com.org.services.PersonService#getPersons()
    */
   @Override
   public List<PersonModel> getPersons()
   {
      return personDao.getPersons();
   }
   
   /**
   * 
   * @see com.org.services.PersonService#update(com.org.model.PersonModel)
   */
   @Override
   public PersonModel update( PersonModel person )
   {
      if( person == null )
      {
         throw new NullPointerException();
      }
      if( person.getId() == null || person.getId() <= 0 )
      {
         throw new IllegalArgumentsException( "Invalid control id <= 0 or null " );
      }
      try
      {
         if( read( person.getId().intValue() ) == null )
         {
            throw new PersonRuntimeException( "Persistence exception detected during the update of the object person the id = " + person.getId() + "does not exist in database" );
         }
         return personDao.update( person );
      }
      catch( PersistenceException ex )
      {
         throw new PersonRuntimeException( "Persistence exception detected during the update of the object DataDefinition ", ex );
      }
   }
   
   /**
    * @see com.org.services.PersonService#create(com.org.model.PersonModel)
    */
   @Override
   public PersonModel create( PersonModel person )
   {
      if( person == null )
      {
         throw new NullPointerException();
      }
      return personDao.create( person );
   }
   
   /**
    * @see com.org.services.PersonService#read(int)
    */
   @Override
   public PersonModel read( Integer id )
   {
      if( id == null || id.intValue() <= 0 )
      {
         throw new IllegalArgumentsException( "Invalid control id <= 0 or null " );
      }
      return personDao.read( id );
   }
}
