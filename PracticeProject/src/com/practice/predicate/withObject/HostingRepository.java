package com.practice.predicate.withObject;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HostingRepository {

    public  static List<Hosting> filterHosting(List<Hosting> hostings, Predicate<Hosting> predicate) {
        return hostings.stream().filter(predicate).collect(Collectors.toList());

    }
}
