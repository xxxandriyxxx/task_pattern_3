package com.epam.view;

import com.epam.controller.Controller;
import com.epam.controller.ControllerImpl;
import com.epam.model.bouquet_catalogue.Bouquet;
import com.epam.model.enums.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class View implements Observer {
    private Controller controller;
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private Scanner input;
    private String keyMenu;
    private Logger logger;
    private List<String> stores;
    private int selectedStoreNum;
    private BaseBouquetType baseBouquetType;
    private PackagingMethod packagingMethod;
    private DeliveryMethod deliveryMethod;
    private DiscountCard discountCard;
    private HashMap<Flower, Integer> additionalFlowers;
    private int customerId;

    public View() {
        controller = new ControllerImpl();
        customerId = 12345;
        controller.registerObserver(this, customerId);
        input = new Scanner(System.in);
        logger = LogManager.getLogger(View.class);
        stores = controller.getStores();
        additionalFlowers = new HashMap<>();
        baseBouquetType = controller.getDefaultBaseBouquetType();
        packagingMethod = controller.getDefaultPackagingMethod();
        deliveryMethod = controller.getDefaultDeliveryMethod();
        discountCard = controller.getDefaultDiscountCard();
        menu = new LinkedHashMap<>();
        menu.put("1", " 1 - select a store");
        menu.put("2", " 2 - select the base bouquet type");
        menu.put("3", " 3 - add flower");
        menu.put("4", " 4 - select a packaging method");
        menu.put("5", " 5 - select a delivery method");
        menu.put("6", " 6 - select a discount card");
        menu.put("7", " 7 - MAKE AN ORDER");
        menu.put("Q", " q - exit");
        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("1", this::selectStore);
        methodsMenu.put("2", this::selectBaseBouquetType);
        methodsMenu.put("3", this::addFlowers);
        methodsMenu.put("4", this::selectPackagingMethod);
        methodsMenu.put("5", this::selectDeliveryMethod);
        methodsMenu.put("6", this::selectDiscountCard);
        methodsMenu.put("7", this::orderBouquet);
        methodsMenu.put("Q", this::exit);
    }

    private void selectStore() {
        for (String store : stores) {
            logger.info(stores.indexOf(store) + 1 + " - " + store);
        }
        logger.trace("-------------------------");
        keyMenu = input.nextLine();
        if (Integer.parseInt(keyMenu) > 0 && Integer.parseInt(keyMenu) <= stores.size()) {
            selectedStoreNum = Integer.parseInt(keyMenu);
        } else {
            logger.error("You entered the wrong symbol!!!");
        }
    }

    private void selectBaseBouquetType() {
        if (selectedStoreNum == 0) {
            logger.error("Select the store first!!!");
        } else {
            List<BaseBouquetType> types = controller.getBaseBouquetTypes();
            for (BaseBouquetType t : types) {
                logger.info(types.indexOf(t) + 1 + " - " + t);
            }
            logger.trace("-------------------------");
            keyMenu = input.nextLine();
            if (Integer.parseInt(keyMenu) > 0 && Integer.parseInt(keyMenu) <= types.size()) {
                baseBouquetType = types.get(Integer.parseInt(keyMenu) - 1);
            } else {
                showInputError();
            }
        }
    }

    private Bouquet getBaseBouquet() {
        return controller.getBouquet(selectedStoreNum, baseBouquetType);
    }

    private void addFlowers() {
        List<Flower> flowers = controller.getFlowers();
        boolean flowerExists = false;
        for (Flower f : flowers) {
            logger.info(flowers.indexOf(f) + 1 + " - " + f);
        }
        logger.trace("-------------------------");
        keyMenu = input.nextLine();
        if (Integer.parseInt(keyMenu) > 0 && Integer.parseInt(keyMenu) <= flowers.size()) {
            for (Map.Entry<Flower, Integer> entry : additionalFlowers.entrySet()) {
                if (entry.getKey().equals(flowers.get(Integer.parseInt(keyMenu) - 1))) {
                    entry.setValue(entry.getValue() + 1);
                    flowerExists = true;
                }
            }
            if (!flowerExists) {
                additionalFlowers.put(flowers.get(Integer.parseInt(keyMenu) - 1), 1);
            }
        } else {
            showInputError();
        }
    }

    private void selectPackagingMethod() {
        List<PackagingMethod> methods = controller.getPackagingMethods();
        for (PackagingMethod m : methods) {
            logger.info(methods.indexOf(m) + 1 + " - " + m);
        }
        logger.trace("-------------------------");
        keyMenu = input.nextLine();
        if (Integer.parseInt(keyMenu) > 0 && Integer.parseInt(keyMenu) <= methods.size()) {
            packagingMethod = methods.get(Integer.parseInt(keyMenu) - 1);
        } else {
            showInputError();
        }
    }

    private void selectDeliveryMethod() {
        List<DeliveryMethod> methods = controller.getDeliveryMethods();
        for (DeliveryMethod m : methods) {
            logger.info(methods.indexOf(m) + 1 + " - " + m);
        }
        logger.trace("-------------------------");
        keyMenu = input.nextLine();
        if (Integer.parseInt(keyMenu) > 0 && Integer.parseInt(keyMenu) <= methods.size()) {
            deliveryMethod = methods.get(Integer.parseInt(keyMenu) - 1);
        } else {
            showInputError();
        }
    }

    private void selectDiscountCard() {
        List<DiscountCard> cards = controller.getDiscountCards();
        for (DiscountCard c : cards) {
            logger.info(cards.indexOf(c) + 1 + " - " + c);
        }
        logger.trace("-------------------------");
        keyMenu = input.nextLine();
        if (Integer.parseInt(keyMenu) > 0 && Integer.parseInt(keyMenu) <= cards.size()) {
            discountCard = cards.get(Integer.parseInt(keyMenu) - 1);
        } else {
            showInputError();
        }
    }

    private void orderBouquet() {
        if (selectedStoreNum == 0) {
            logger.error("FAILURE: no selected store!!!");
        } else if (getBaseBouquet().getFlowers().isEmpty() && additionalFlowers.isEmpty()) {
            logger.error("FAILURE: the base bouquet is empty and no additional flowers!!!");
        } else {
            Bouquet orderedBouquet = controller.orderBouquet(selectedStoreNum, baseBouquetType, additionalFlowers, packagingMethod,
                    deliveryMethod, discountCard, customerId);
            logger.debug("-------------------------");
            logger.debug("Details of the bouquet:");
            logger.debug("Name: " + orderedBouquet.getName());
            logger.debug("Flowers: " + orderedBouquet.getFlowers());
            logger.debug("Cost: " + orderedBouquet.getCost());
            logger.debug("Packaging method: " + orderedBouquet.getPackagingMethod());
            logger.debug("Delivery method: " + orderedBouquet.getDeliveryMethod());
            logger.debug("Discount card used: " + discountCard);
        }
    }

    private void exit() {
        System.exit(0);
    }

    private void outputMenu() {
        logger.trace("\n==================== MENU ====================");
        if (selectedStoreNum > 0) {
            logger.info("Selected store: " + stores.get(selectedStoreNum - 1));
            logger.info("Base bouquet: " + baseBouquetType + " -> "
                    + getBaseBouquet());
        } else {
            logger.error("No selected store");
        }
        logger.info("Additional flowers: " + additionalFlowers);
        logger.info("Packaging method: " + packagingMethod);
        logger.info("Delivery method: " + deliveryMethod);
        logger.info("Discount card: " + discountCard);
        logger.trace("----------------------------------------------");
        for (String str : menu.values()) {
            logger.trace(str);
        }
    }

    public void show() {
        do {
            outputMenu();
            logger.trace("----------------------------------------------");
            logger.trace("Enter the menu point:");
            keyMenu = input.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                showInputError();
            }
        } while (!keyMenu.equals("Q"));
    }

    private void showInputError() {
        logger.error("You entered the wrong symbol!!!");
    }

    @Override
    public void notification(String message) {
        logger.warn(message);
    }
}
