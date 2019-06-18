package guru.springframework.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {

	private CategoryRepository CategoryRepository;
	private UnitOfMeasureRepository UnitOfMeasureRepository;

	@Autowired
	public IndexController(guru.springframework.repositories.CategoryRepository categoryRepository,
			guru.springframework.repositories.UnitOfMeasureRepository unitOfMeasureRepository) {
		super();
		CategoryRepository = categoryRepository;
		UnitOfMeasureRepository = unitOfMeasureRepository;
	}

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage() {
		
		Optional<Category> categoryOptional = CategoryRepository.findByDescription("American");
		Optional<UnitOfMeasure> unitOfMeasureOptional = UnitOfMeasureRepository.findByDescription("Teaspoon");
		
		System.out.println("Cat id is:" + categoryOptional.get().getId());
		System.out.println("Uom id is:" + unitOfMeasureOptional.get().getId());
		
		return "index";
	}
}
