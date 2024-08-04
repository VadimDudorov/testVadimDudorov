package com.gridnine.testing;

import java.util.List;

public interface FilteringRules <T>{
    List<T> filtering(List<T> value);
}
