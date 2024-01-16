package com.magnetron.billing.domain.services;

import java.util.List;

public interface ImplViewService<T> {
    List<T> getAll();

}