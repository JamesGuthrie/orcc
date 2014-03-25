package net.sf.orcc.backends.c;

import net.sf.orcc.df.Actor;
import net.sf.orcc.df.Instance;
import net.sf.orcc.df.Network;
import net.sf.orcc.util.OrccLogger;

public class CValidator {

    public static void checkFunctionNames(Network network){
        for (Actor actor : network.getAllActors()) {
            for (Instance instance : network.getInstancesOf(actor)) {
                if (!CValidator.isValidCFunction(instance.getName())){
                    OrccLogger.warnln("Instance " + instance.getName() + " of actor " + actor.getName() + " not a valid C function name");
                }
            }
        }
    }
    
    public static boolean isValidCFunction(String s){
        if (s.length() > 0 && !s.substring(0,1).matches("[0-9]")){
            return true;
        }
        return false;
    }
    

}
