package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/car")
public
class CarController {

    private final
    CarService carService;

    @Autowired
    public
    CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public
    ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("car_list");
        List<Car> carList = carService.getAllCars();
        modelAndView.addObject("car_list", carList);

        return modelAndView;
    }

    @RequestMapping(value = "/addCar/", method = RequestMethod.GET)
    public ModelAndView addCar(){
        ModelAndView modelAndView = new ModelAndView();
        Car car = new Car();
        modelAndView.addObject("carForm", car);
        modelAndView.setViewName("car_form");

        return modelAndView;
    }

    @RequestMapping(value = "/updateCar/{id}", method = RequestMethod.GET)
    public ModelAndView editCar(@PathVariable Long id){
        ModelAndView model = new ModelAndView();

        Optional<Car> carOptional = carService.getCarById(id);
        Car car;
        car = carOptional.orElseGet(Car::new);
        model.addObject("carForm", car);
        model.setViewName("car_form");

        return model;
    }

    @RequestMapping(value="/saveCar", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("carForm") Car car) {
        carService.saveOrUpdate(car);

        return new ModelAndView("redirect:/car/list");
    }

    @RequestMapping(value="/deleteCar/{id}", method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") long id) {
        carService.deleteCar(id);

        return new ModelAndView("redirect:/Car/list");
    }
}
