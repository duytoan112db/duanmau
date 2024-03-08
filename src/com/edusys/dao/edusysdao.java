/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.dao;

import java.util.List;



/**
 *
 * @author Duy Toan
 */
public abstract class edusysdao<E,K> {
    abstract public void insert (E entity);
    abstract public void update(E entity);
    abstract public void delete (K entity);
    abstract public List<E> selectall();
    abstract public E selectbyid (K key);
    abstract protected List<E> selectbysql (String sql , Object ...args);
}
