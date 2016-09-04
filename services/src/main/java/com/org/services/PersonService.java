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
 * Fichier 		:	PersonService.java
 * Cree le 		: 	4 sept. 2016 à 14:16:14
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.services;

import java.util.List;

import com.org.exception.PersonRuntimeException;
import com.org.model.PersonModel;

/**
 * A Renseigner.
 * @author  : mmenhour
 * @project : services
 * @package : com.org.services
 * @date    : 4 sept. 2016 14:16:14
 */
public interface PersonService
{
   /**
    * 
    * @param firstName
    * @return
    */
   List<PersonModel> getPersons();
   
   /**
    * 
    * @param person
    * @return
    */
   PersonModel update( PersonModel person );
   
   /**
    * 
    * @param person
    * @return
    */
   PersonModel create( PersonModel person );
   
   /**
    * 
    * @param id
    * @return
    */
   PersonModel read( Integer id );
   
   /**
    * 
    * @param lastName
    * @return
    */
   PersonModel getPersonByLastName( String lastName );
   
   /**
   * 
   * @param firstName
   * @return
   */
   PersonModel getPersonByFirstName( String firstName );
}
