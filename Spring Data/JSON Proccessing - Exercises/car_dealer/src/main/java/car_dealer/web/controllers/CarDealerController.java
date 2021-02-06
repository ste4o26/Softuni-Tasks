package car_dealer.web.controllers;

import car_dealer.domain.dtos.*;
import car_dealer.services.interfaces.*;
import car_dealer.utils.FileUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarDealerController implements CommandLineRunner {
    private final SupplierService supplierService;
    private final PartService partService;

    private final FileUtil fileUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private CarService carService;
    private CustomerService customerService;
    private SaleService saleService;

    //TODO get fill with random values

    @Autowired
    public CarDealerController(SupplierService supplierService, PartService partService, FileUtil fileUtil, ModelMapper modelMapper, Gson gson, CarService carService, CustomerService customerService, SaleService saleService) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.fileUtil = fileUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedDatabase();
    }

    private void seedDatabase() {
        try {
            this.seedSuppliers();
//            this.seedParts();
//            this.seedCars();
//            this.seedCustomers();
        } catch (IOException | URISyntaxException e) {
            System.err.println(String.format("%s with message: %s",
                    e.getClass().getSimpleName(),
                    e.getMessage()));
        }


        try {
            this.seedSales();
//            this.orderCustomers();
//            this.carsFromMakeToyota();
//            this.localSuppliers();
//            this.carsWithTheirListOfParts();
            this.totalSalesByCustomer();
        } catch (IllegalStateException ise) {
            System.err.println(String.format("%s with message: %s",
                    ise.getClass().getSimpleName(),
                    ise.getMessage()));
        }
    }

    private void seedSuppliers() throws IOException, URISyntaxException {
        String json = String.join("", this.fileUtil
                .getFileLines("files/suppliers.json"));

        List<SupplierCreateDto> supplierCreateDtoList = Arrays.stream(this.gson
                .fromJson(json, SupplierCreateDto[].class))
                .collect(Collectors.toList());

        this.supplierService.seedSuppliers(supplierCreateDtoList);
    }

    private void seedParts() throws IOException, URISyntaxException {
        String json = String.join("", this.fileUtil
                .getFileLines("files/parts.json"));

        List<PartCreateDto> partCreateDtoList = Arrays.stream(this.gson
                .fromJson(json, PartCreateDto[].class))
                .collect(Collectors.toList());

        try {
            this.partService.seedParts(partCreateDtoList);
        } catch (IllegalArgumentException iae) {
            System.err.println(String.format("%s with message: %s",
                    iae.getClass().getSimpleName(),
                    iae.getMessage()));
        }
    }

    private void seedCars() throws IOException, URISyntaxException {
        String json = String.join("", this.fileUtil
                .getFileLines("files/cars.json"));

        List<CarCreateDto> carCreateDtoList = Arrays.stream(this.gson
                .fromJson(json, CarCreateDto[].class))
                .collect(Collectors.toList());

        try {
            this.carService.seedCars(carCreateDtoList);
        } catch (IllegalArgumentException iae) {
            System.err.println(String.format("%s with message: %s",
                    iae.getClass().getSimpleName(),
                    iae.getMessage()));
        }
    }

    private void seedCustomers() throws IOException, URISyntaxException {
        String json = String.join("", this.fileUtil
                .getFileLines("files/customers.json"));

        List<CustomerCreateDto> customerCreateDtoList = Arrays.stream(this.gson
                .fromJson(json, CustomerCreateDto[].class))
                .collect(Collectors.toList());
        //TODO
        this.customerService.seedCustomers(customerCreateDtoList);
    }

    private void seedSales() {
        this.saleService.seedSales();
    }

    /**
     * Query 1 – Ordered Customers
     */
    private void orderCustomers() throws IllegalStateException {
        List<CustomerViewDto> customerViewDtoList =
                this.customerService.getCustomersOrderByBirthDateAndExperience();

        System.out.println(this.gson.toJson(customerViewDtoList));
    }

    /**
     * Query 2 – Cars from Make Toyota
     */
    private void carsFromMakeToyota() throws IllegalStateException {
        List<CarViewDto> carViewDtoList = this.carService.getAllCarsWithMakeToyota();
        System.out.println(this.gson.toJson(carViewDtoList));
    }

    /**
     * Query 3 - Local Suppliers
     */
    private void localSuppliers() throws IllegalStateException {
        List<SupplierViewDto> supplierViewDtoList = this.supplierService.getAllLocalSuppliers();
        System.out.println(this.gson.toJson(supplierViewDtoList));
    }

    /**
     * Query 4 – Cars with Their List of Parts
     */
    private void carsWithTheirListOfParts() {
        List<CarPartViewDto> carPartViewDtoList = this.carService.getAllCarsAndTheirParts();
        System.out.println(this.gson.toJson(carPartViewDtoList));
    }

    /**
     * Query 5 – Total Sales by Customer
     */
    private void totalSalesByCustomer() {
        List<CustomerTotalSalesViewDto> customerTotalSalesViewDtoList = this.customerService.totalSalesByCustomer();
        System.out.println(this.gson.toJson(customerTotalSalesViewDtoList));
    }
}
