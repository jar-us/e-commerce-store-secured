package e.com.db;

import e.com.db.entity.Category;
import e.com.db.repo.CategoryRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;
    private Category category1 = null;
    private Category category2 = null;

    @BeforeEach
    public void setup() {
        category1 = new Category(null, "Test Category 1");
        category2 = new Category(null, "Test Category 2");
        categoryRepository.save(category1);
        categoryRepository.save(category2);
    }

    @Test
    public void testSaveCategory() {
        assertNotNull(category1.getId());
    }

    @Test
    public void testFindCategoryById() {
        Category foundCategory = categoryRepository.findById(category1.getId()).orElse(null);
        assertNotNull(foundCategory);
        assertEquals(category1.getName(), foundCategory.getName());
    }

    @Test
    public void testFindAllCategories() {
        Iterable<Category> categories = categoryRepository.findAll();
        List<Category> categoryList = StreamSupport.stream(categories.spliterator(), false).collect(Collectors.toList());
        MatcherAssert.assertThat(categoryList, Matchers.hasSize(2));
    }

    @Test
    public void testDeleteCategory() {
        categoryRepository.delete(category1);
        assertNull(categoryRepository.findById(category1.getId()).orElse(null));
    }
}
