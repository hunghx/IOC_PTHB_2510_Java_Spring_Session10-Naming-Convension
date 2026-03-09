package ra.api.service;

import ra.api.exception.ResourcesNotFoundException;

import java.util.List;

public interface IGenericService <U,V, ID, E> {
    List<E> findAll();
    E create(U u);
    E update(V v, ID id) throws ResourcesNotFoundException;
    E findById(ID id) throws ResourcesNotFoundException;
    void delete(ID id) throws ResourcesNotFoundException;
}
