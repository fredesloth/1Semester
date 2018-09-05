package application.model;

import application.service.Service;

public class Test {

    public static void main(String[] args) {
        Bil b1 = new Bil("BMW", Bilgruppe.A, 23, 4, 230);

        System.out.println(Service.getPris(b1));
    }

}
