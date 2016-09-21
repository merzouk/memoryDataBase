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
 * Fichier 		:	UpdateCreate.java
 * Cree le 		: 	20 sept. 2016 à 22:52:37
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.usecases;

/**
 * A Renseigner.
 * @author  : admin
 * @project : use-cases
 * @package : com.org.usecases
 * @date    : 20 sept. 2016 22:52:37
 */
public interface UpdateCreatePerson<T>
{
   /**
    * 
    * @param t
    * @return
    */
   T update( T t );
   
   /**
    * 
    * @param t
    * @return
    */
   T create( T t );
   
   
}
