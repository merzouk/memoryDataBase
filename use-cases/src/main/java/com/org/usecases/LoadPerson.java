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
 * Fichier 		:	LoadPerson.java
 * Cree le 		: 	20 sept. 2016 à 22:50:04
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.usecases;

import java.io.Serializable;
import java.util.List;

/**
 * A Renseigner.
 * @author  : admin
 * @project : use-cases
 * @package : com.org.usecases
 * @date    : 20 sept. 2016 22:50:04
 */
public interface LoadPerson<T, I extends Serializable>
{
   /**
    * 
    * @return
    */
   List<T> getAll();
   
   /**
    * 
    * @param id
    * @return
    */
   T getById( I primaryKey );
}
