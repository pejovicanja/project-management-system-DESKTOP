/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domain.GenericEntity;
import java.util.List;

/**
 *
 * @author HP
 * @param <T>
 * @param <K>
 */
public interface Repository<T extends GenericEntity, K> {
     void save(T parameter) throws Exception;
    
    void update(T parameter) throws Exception;
    
    void delete(T parameter) throws Exception;
    
    List<T> getAll(T parameter) throws Exception;
    
    List<T> getAllByFilter(T parameter, K filter) throws Exception;
    
    List<T> getAllByObject(T parameter, K object) throws Exception;
}
