package com.example.demo.repositories;


import com.example.demo.exception.UnknownDeveloperException;
import com.example.demo.exception.UnknownFeedException;
import com.example.demo.model.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
@Service
public interface FeedRepository extends JpaRepository<Feed,Integer> {

}
