package assembler;

import businessLogic.BusinessLogicAPI;
import frontend.Simulation;

/**
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class Main {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
                new Simulation(new BusinessLogicAPI()).show();
        }
}
