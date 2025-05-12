package com.beeorg.mymarketing.service.handler;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class CrudServiceHandler {

    public static <T, E> T save(
            T request,
            Function<T, E> builder,
            Function<E, E> repository,
            Function<E, T> reverser
    ) {
        E entity = builder.apply(request);
        E savedEntity = repository.apply(entity);
        return reverser.apply(savedEntity);
    }

    public static <T, E> T update(
            T request,
            Function<T, E> builder,
            Function<E, E> repository,
            Function<E, T> reverser
    ) {
        return save(request, builder, repository, reverser);
    }

    public static <R, E> List<R> read(
            Supplier<List<E>> supplier,
            Function<E, R> reverser
    ) {
        List<E> entityList = supplier.get();
        return entityList.stream().map(reverser).toList();
    }

    public static <T, E> T readDetail(
            Integer id,
            Function<Integer, Optional<E>> read,
            Supplier<E> defaultSupplier,
            Function<E, T> reverser
    ) {
        E entity = read.apply(id).orElseGet(defaultSupplier);
        return reverser.apply(entity);
    }

    public static <E, R> R delete(
            Integer id,
            Function<Integer, Optional<E>> reader,
            Supplier<E> defaultSupplier,
            Consumer<Integer> repository,
            Function<E, R> reverser
    ) {
        E entity = reader.apply(id).orElseGet(defaultSupplier);
        repository.accept(id);
        return reverser.apply(entity);
    }
}
