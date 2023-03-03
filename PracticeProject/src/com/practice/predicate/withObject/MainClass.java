package com.practice.predicate.withObject;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MainClass {

    public static void main(String[] args) {
        Hosting h1 = new Hosting(1, "amazon", "aws.amazon.com");
        Hosting h2 = new Hosting(2, "linode", "linode.com");
        Hosting h3 = new Hosting(3, "liquidweb", "liquidweb.com");
        Hosting h4 = new Hosting(4, "google", "google.com");

        List<Hosting> list = Arrays.asList(new Hosting[]{h1, h2, h3, h4});

        List<Hosting> hostingList = HostingRepository.filterHosting(list, x -> x.getName().length() > 5);
        for (Hosting s:hostingList) {
            System.out.println(s.getName());

        }


    }
}
