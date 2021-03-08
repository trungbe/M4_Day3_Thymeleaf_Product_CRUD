package controller;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import service.IProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list", "list", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Product product) {
        int id = productService.findAll().size();
        product.setId(id);
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("create", "product", new Product());
        modelAndView.addObject("mess", "Tao moi thanh cong product ten la " + product.getName());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable int id, ModelMap modelMap) {
        Product product =productService.findById(id);
        modelMap.addAttribute("product", product);
        return "edit";
    }
    @PostMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id, @ModelAttribute Product product) {
        product.setId(id);
        productService.update(product);
        return new ModelAndView("list", "list", productService.findAll());
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        productService.remove(id);
        return modelAndView;
    }
    @GetMapping("/view/{id}")
    public ModelAndView viewDetail(@PathVariable int id){
        return new ModelAndView("view", "product", productService.findById(id));
    }
}
