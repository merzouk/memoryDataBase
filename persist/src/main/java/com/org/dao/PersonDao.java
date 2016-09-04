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
 * Fichier 		:	PersonDao.java
 * Cree le 		: 	4 sept. 2016 à 13:46:52
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.dao;

import java.util.List;

import com.org.exception.PersonRuntimeException;
import com.org.model.PersonModel;

/**
 * A Renseigner.
 * @author  : mmenhour
 * @project : persist
 * @package : com.org.dao
 * @date    : 4 sept. 2016 13:46:52
 */
public interface PersonDao
{
   
   /**
    * 
    * @param email
    * @return
    */
   List<PersonModel> personsByEmail( String email ) throws PersonRuntimeException;
   
   /**
   * 
   * @return
   * @throws PersonRuntimeException
   */
   List<PersonModel> getPersons() throws PersonRuntimeException;
   
   /**
   * 
   * @param person
   * @return
   * @throws PersonRuntimeException
   */
   PersonModel update( PersonModel person ) throws PersonRuntimeException;
   
   /**
   * 
   * @param person
   * @return
   * @throws PersonRuntimeException
   */
   PersonModel create( PersonModel person ) throws PersonRuntimeException;
   
   /**
   * 
   * @param id
   * @return
   * @throws PersonRuntimeException
   */
   PersonModel read( Integer id ) throws PersonRuntimeException;
}
