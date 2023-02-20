package com.example.Wishlist;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WisherRepo extends CrudRepository<Wisher, Long> {

    Optional<Wisher> getWisherByUsnAndPsw(String usn, String psw);

}
