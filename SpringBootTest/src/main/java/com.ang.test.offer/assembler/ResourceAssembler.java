package com.ang.test.offer.assembler;

import java.util.List;

abstract class ResourceAssembler<T, U> {

    public abstract T toResource(U var1);

    public abstract List<T> toResourceList(Iterable<U> entities);

    public abstract U toResourceInverse(T var1);

    public abstract List<U> toResourceInverse(Iterable<T> entities);
}
