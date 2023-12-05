package com.example.springmysql.controller;

import com.example.springmysql.dao.AllDAO;
import com.example.springmysql.newModels.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String showHome(){
        return "home";
    }

    private final AllDAO _allDAO;

    @Autowired
    public HomeController(AllDAO allDAO){
        this._allDAO = allDAO;
    }

    @GetMapping("/home/indexCategory")
    public String categoryIndex(Model model) throws SQLException {
        model.addAttribute("categoryList", (List<Category>)(Object)_allDAO.get(new Category()));//список всех категорий
        return "indexCategory";
    }

    @GetMapping("/home/indexUser")
    public String userIndex(Model model) throws SQLException {
        model.addAttribute("userList", (List<User>)(Object)_allDAO.get(new User()));//список всех пользователей
        return "indexUser";
    }

    @GetMapping("/home/indexProduct")
    public String productIndex(Model model) throws SQLException {
        model.addAttribute("productList", (List<Product>)(Object)_allDAO.get(new Product()));//список всех товаров
        return "indexProduct";
    }

    @GetMapping("/home/indexOrdering")
    public String orderingIndex(Model model) throws SQLException {
        model.addAttribute("orderingList", (List<Ordering>)(Object)_allDAO.get(new Ordering()));//список всех заказов
        return "indexOrdering";
    }

    @GetMapping("/home/indexRole")
    public String roleIndex(Model model) throws SQLException {
        model.addAttribute("roleList", (List<Role>)(Object)_allDAO.get(new Role()));//список всех ролей
        return "indexRole";
    }

    @GetMapping("/home/indexSupplier")
    public String supplierIndex(Model model) throws SQLException {
        model.addAttribute("supplierList", (List<Supplier>)(Object)_allDAO.get(new Supplier()));//список всех поставщиков
        return "indexSupplier";
    }

    @GetMapping("/home/indexBenefit")
    public String benefitIndex(Model model) throws SQLException {
        model.addAttribute("benefitList", (List<Benefit>)(Object)_allDAO.get(new Benefit()));//список всех льгот
        return "indexBenefit";
    }

    @GetMapping("/home/indexFeedback")
    public String feedbackIndex(Model model) throws SQLException {
        model.addAttribute("feedbackList", (List<Feedback>)(Object)_allDAO.get(new Feedback()));//список всех отзывов
        return "indexFeedback";
    }

//    @GetMapping("/home/indexPeople")
//    public String peopleIndex(Model model) throws SQLException {
//        model.addAttribute("peopleList", (List<People>)(Object)_allDAO.get(new People()));//список всех людей
//        return "indexPeople";
//    }


 //---------------------------- Поиск ---------------------------------

    @GetMapping("/home/indexCategoryByName")
    public String categoryIndexSearch(Model model,
                                    @RequestParam("name") String name) throws SQLException {
        List<Category> category = (List<Category>)(Object)_allDAO.get(new Category());
        category = category.stream().filter(category1 -> category1.getCategoryName().toLowerCase().contains(name.toLowerCase())).toList();
        model.addAttribute("categoryList", category);//список всех категорий, соответсвующих поиску
        return "indexCategory";
    }

 //--------------------------------------------------------------------

    @GetMapping("/home/indexCategory/showCategory/{id}")
    public String categoryShow(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("category", (Category)_allDAO.get(id, new Category()));//получение одной категории по id
        return "showCategory";
    }

    @GetMapping("/home/indexUser/showUser/{id}")
    public String userShow(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("user", (User)_allDAO.get(id, new User()));
        return "showUser";
    }

    @GetMapping("/home/indexProduct/showProduct/{id}")
    public String productShow(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("product", (Product)_allDAO.get(id, new Product()));
        return "showProduct";
    }

    @GetMapping("/home/indexOrdering/showOrdering/{id}")
    public String orderingShow(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("ordering", (Ordering)_allDAO.get(id, new Ordering()));
        return "showOrdering";
    }



    @GetMapping("/home/indexRole/showRole/{id}")
    public String roleShow(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("role", (Role)_allDAO.get(id, new Role()));
        return "showRole";
    }

    @GetMapping("/home/indexSupplier/showSupplier/{id}")
    public String supplierShow(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("supplier", (Supplier)_allDAO.get(id, new Supplier()));
        return "showSupplier";
    }

    @GetMapping("/home/indexBenefit/showBenefit/{id}")
    public String benefitShow(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("benefit", (Benefit)_allDAO.get(id, new Benefit()));
        return "showBenefit";
    }

    @GetMapping("/home/indexFeedback/showFeedback/{id}")
    public String feedbackShow(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("feedback", (Feedback)_allDAO.get(id, new Feedback()));
        return "showFeedback";
    }

//    @GetMapping("/home/indexPeople/showPeople/{id}")
//    public String peopleShow(@PathVariable("id") int id, Model model) throws SQLException {
//        model.addAttribute("people", (People)_allDAO.get(id, new People()));
//        return "showPeople";
//    }

    @PostMapping("/home/CRUDresult")
    public RedirectView newAdd(Model model,
                               @RequestParam (name = "param1", required = false, defaultValue = "-") String param1,
                               @RequestParam (name = "param2", required = false, defaultValue = "-") String param2,
                               @RequestParam (name = "param3", required = false, defaultValue = "-") String param3,
                               @RequestParam (name = "param4", required = false, defaultValue = "-") String param4,
                               @RequestParam (name = "param5", required = false, defaultValue = "-") String param5,
                               @RequestParam (name = "type5", required = false, defaultValue = "-") String type5){
        String returnString = "home";
        try {
            Object object = new Object();
            switch (type5) {
                case "c":
                    object = new Category(0, param1, param2);
                    returnString = "indexCategory";
                    break;
                case "u":
                    object = new User(0, param1, param2, param3, Integer.parseInt(param4), param5);
                    returnString = "indexUser";
                    break;
                case "p":
                    object = new Product(0, param1, param2);
                    returnString = "indexProduct";
                    break;
                case "o":
                    object = new Ordering(0, param1);
                    returnString = "indexOrdering";
                    break;


                case "r":
                    object = new Role(0, param1);
                    returnString = "indexRole";
                    break;
                case "s":
                    object = new Supplier(0, param1);
                    returnString = "indexSupplier";
                    break;
                case "b":
                    object = new Benefit(0, param1, Integer.parseInt(param2));
                    returnString = "indexBenefit";
                    break;
                case "f":
                    object = new Feedback(0, param1);
                    returnString = "indexFeedback";
                    break;

//                case "p":
//                    object = new People(0, param1, Integer.parseInt(param2), param3, param4);
//                    returnString = "indexPeople";
//                    break;
            }
            if(object.getClass() != Object.class) {
                Logger.getAnonymousLogger().info("Here");
                _allDAO.add(object);
            }
        }
        catch (Exception e){
            model.addAttribute("message", "Что-то пошло не так");
        }
        return new RedirectView(returnString);
    }
}
