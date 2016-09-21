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

import java.io.Serializable;
import java.util.List;

import com.org.exception.PersonRuntimeException;

/**
 * A Renseigner.
 * @author  : mmenhour
 * @project : persist
 * @package : com.org.dao
 * @date    : 4 sept. 2016 13:46:52
 */
public interface PersonDao<T, I extends Serializable>
{
   
   /**
   * 
   * @param email
   * @return
   * @throws PersonRuntimeException
   */
   List<T> getByEmail( String email ) throws PersonRuntimeException;
   
   /**
    * 
    * @return
    * @throws PersonRuntimeException
    */
   List<T> getAll() throws PersonRuntimeException;
   
   /**
    * 
    * @param t
    * @return
    * @throws PersonRuntimeException
    */
   T update( T t ) throws PersonRuntimeException;
   
   /**
    * 
    * @param t
    * @return
    * @throws PersonRuntimeException
    */
   T create( T t ) throws PersonRuntimeException;
   
   /**
    * 
    * @param primaryKey
    * @return
    * @throws PersonRuntimeException
    */
   T read( I primaryKey ) throws PersonRuntimeException;
   
   /**
    * 
    * @param primaryKey
    * @throws PersonRuntimeException
    */
   void deleteById( I primaryKey ) throws PersonRuntimeException;
   
   /**
    * 
    * @param t
    * @throws PersonRuntimeException
    */
   void delete( T t ) throws PersonRuntimeException;
}
