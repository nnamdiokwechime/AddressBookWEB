package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {
    @Autowired
    AddressBookRepository repo;
    AddressBook book;

    /*@GetMapping("/")
    public @RequestBody String display(Model model){
        model.addAttribute("name", book.toString());
        return "Hello, World";
    }
    */

    @GetMapping("/")
    public @ResponseBody String greeting(){
        return "Hello, World";
    }

    @GetMapping("/makebook")
    public String makeBook(Model model){
        book = new AddressBook();
        model.addAttribute("name",book.toString());
        return "buddy";
    }


    @GetMapping("/hello")
    public String hello(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "buddy";
    }

    @GetMapping("/add")
    public String add(@RequestParam(name = "name") String name, Model model){
        book.addBuddy(name);
        model.addAttribute("name", book.toString());
        return "buddy";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam(value = "value") Integer value, Model model){
        book.removeBuddy(value);
        model.addAttribute("name", book.toString());
        return "buddy";
    }


}
