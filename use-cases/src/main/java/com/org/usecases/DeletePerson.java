/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : use-cases
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
 * Fichier 		:	DeletePerson.java
 * Cree le 		: 	20 sept. 2016 à 22:53:58
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.usecases;

import java.io.Serializable;

/**
 * A Renseigner.
 * @author  : admin
 * @project : use-cases
 * @package : com.org.usecases
 * @date    : 20 sept. 2016 22:53:58
 */
public interface DeletePerson<T, I extends Serializable>
{
   /**
    * 
    * @param primaryKey
    */
   void deleteById( I primaryKey );
   
   /**
    * 
    * @param t
    */
   void delete( T t );
}
