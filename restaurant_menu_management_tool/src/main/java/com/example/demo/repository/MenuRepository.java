package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.MenuModel;


@Repository
public interface MenuRepository extends JpaRepository<MenuModel,Integer> {

	List<MenuModel> findByTitle(String title);
}
