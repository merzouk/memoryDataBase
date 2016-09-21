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
 * Fichier 		:	PersonServiceTest.java
 * Cree le 		: 	4 sept. 2016 à 14:29:24
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.usecases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.org.exception.IllegalArgumentsException;
import com.org.exception.PersonRuntimeException;
import com.org.model.PersonModel;

/**
 * A Renseigner.
 * @author  : admin
 * @project : services
 * @package : com.org.services
 * @date    : 4 sept. 2016 14:29:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(locations = { "classpath:META-INF/spring/ref-datasource-test.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonServiceTest
{
   @SuppressWarnings("unused")
   @Autowired
   private DeletePerson<PersonModel, Integer> deleteService;
   
   @Autowired
   private LoadPerson<PersonModel, Integer>   loadPerson;
   
   @Autowired
   private UpdateCreatePerson<PersonModel>    updateCreatePerson;
   
   @Before
   public void init()
   {
      try
      {
         
      }
      catch( Exception e )
      {
         // TODO: handle exception
      }
   }
   
   @After
   public void destroy()
   {
      try
      {
         
      }
      catch( Exception e )
      {
         // TODO: handle exception
      }
   }
   
   @Test
   public void test_a()
   {
      try
      {
         @SuppressWarnings("unused")
         PersonModel data = loadPerson.getById( 0 );
         fail();
      }
      catch( IllegalArgumentsException ex )
      {
         
      }
   }
   
   @Test
   public void test_b()
   {
      PersonModel data = null;
      data = loadPerson.getById( 1 );
      assertNotNull( data );
      assertEquals( "firstName1", data.getFirstName() );
      assertEquals( "courriel1@email.com", data.getEmail() );
   }
   
   @Test
   public void test_c()
   {
      PersonModel data = null;
      data = loadPerson.getById( 6 );
      assertNotNull( data );
      assertEquals( "lastName6", data.getLastName() );
      assertEquals( "courriel6@email.com", data.getEmail() );
   }
   
   @Test(expected = PersonRuntimeException.class)
   public void test_d()
   {
      @SuppressWarnings("unused")
      PersonModel data = loadPerson.getById( 50 );
   }
   
   @Test
   public void test_e()
   {
      List<PersonModel> datas = loadPerson.getAll();
      assertNotNull( datas );
      assertEquals( 6, datas.size() );
   }
   
   @Test
   public void test_f()
   {
      PersonModel person = new PersonModel();
      person.setEmail( "courriel7@email.com" );
      person.setFirstName( "firstName7" );
      person.setLastName( "lastName7" );
      person = updateCreatePerson.create( person );
      assertNotNull( person );
      assertEquals( 7, person.getId().intValue() );
   }
   
   @Test
   public void test_g()
   {
      List<PersonModel> datas = loadPerson.getAll();
      assertNotNull( datas );
      assertEquals( 7, datas.size() );
   }
   
   @Test
   public void test_k()
   {
      PersonModel person = new PersonModel();
      person.setEmail( "courriel7_bis@email.com" );
      person.setFirstName( "firstName7_bis" );
      person.setLastName( "lastName7_bis" );
      person.setId( 7 );
      person = updateCreatePerson.update( person );
      assertNotNull( person );
      assertEquals( "firstName7_bis", person.getFirstName() );
      assertEquals( "courriel7_bis@email.com", person.getEmail() );
      assertEquals( "lastName7_bis", person.getLastName() );
   }
   
   @Test
   public void test_l()
   {
      List<PersonModel> datas = loadPerson.getAll();
      assertNotNull( datas );
      assertEquals( 7, datas.size() );
   }
}