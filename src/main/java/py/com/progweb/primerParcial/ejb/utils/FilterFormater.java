package py.com.progweb.primerParcial.ejb.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FilterFormater {

    public static String getFinalUsuarioFilter(Map<String, List<String>> paramsMap) {

        String joinedCondition;
        String finalFilter = "";
        if (paramsMap.get("nombre") != null) {
            List<String> condicionesNombre = new ArrayList<>();
            for (String nombre : paramsMap.get("nombre"))
                condicionesNombre.add("lower(nombre) like '%" + nombre.toLowerCase() + "%'");
            joinedCondition = String.join(" OR ", condicionesNombre);
            if (joinedCondition.length() > 0) finalFilter = joinedCondition;
        }
        if (paramsMap.get("apellido") != null) {
            List<String> condicionesApellido = new ArrayList<>();
            for (String apellido : paramsMap.get("apellido"))
                condicionesApellido.add("lower(apellido) like '%" + apellido.toLowerCase() + "%'");
            joinedCondition = String.join(" OR ", condicionesApellido);
            if (joinedCondition.length() > 0) {
                if (finalFilter.length() > 0)
                    finalFilter = String.format("(%s) AND (%s)", finalFilter, joinedCondition);
                else
                    finalFilter = joinedCondition;
            }
        }
        if (paramsMap.get("fechaNacimiento") != null) {
            List<String> condicionesFechaNacimiento = new ArrayList<>();
            for (String fechaNacimiento : paramsMap.get("fechaNacimiento"))
                condicionesFechaNacimiento.add("fechaNacimiento='" + fechaNacimiento + "'");
            joinedCondition = String.join(" OR ", condicionesFechaNacimiento);
            if (joinedCondition.length() > 0) {
                if (finalFilter.length() > 0)
                    finalFilter = String.format("(%s) AND (%s)", finalFilter, joinedCondition);
                else
                    finalFilter = joinedCondition;
            }

        }
        return finalFilter;
    }

    public static String getUsoPuntosFilter(Map<String, List<String>> paramsMap){
        String joinedCondition;
        String finalFilter = "";
        if(paramsMap.get("concepto") != null){
            List<String> condicionesConcepto = new ArrayList<>();
            for(String concepto: paramsMap.get("concepto"))
                condicionesConcepto.add("concepto_uso_id=" + concepto);
            joinedCondition = String.join(" OR ", condicionesConcepto);
            if (joinedCondition.length() > 0) finalFilter = joinedCondition;
        }

        if(paramsMap.get("fecha") != null){
            List<String> condicionesFecha = new ArrayList<>();
            for(String fecha: paramsMap.get("fecha"))
                condicionesFecha.add("fecha='" + fecha + "'");
            joinedCondition = String.join(" OR ", condicionesFecha);
            if (joinedCondition.length() > 0) {
                if (finalFilter.length() > 0)
                    finalFilter = String.format("(%s) AND (%s)", finalFilter, joinedCondition);
                else
                    finalFilter = joinedCondition;
            }
        }

        if(paramsMap.get("cliente") != null){
            List<String> condicionesCliente = new ArrayList<>();
            for(String cliente: paramsMap.get("cliente"))
                condicionesCliente.add("usuario_id=" + cliente);
            joinedCondition = String.join(" OR ", condicionesCliente);
            if (joinedCondition.length() > 0) {
                if (finalFilter.length() > 0)
                    finalFilter = String.format("(%s) AND (%s)", finalFilter, joinedCondition);
                else
                    finalFilter = joinedCondition;
            }
        }

        return finalFilter;
    }

    public static String getBolsaFilter(Map<String, List<String>> paramsMap){
        String joinedCondition;
        String finalFilter = "";

        if(paramsMap.get("cliente") != null){
            List<String> condicionesCliente = new ArrayList<>();
            for(String id: paramsMap.get("cliente"))
                condicionesCliente.add("id_usuario=" + id);
            joinedCondition = String.join(" OR ", condicionesCliente);
            if (joinedCondition.length() > 0) finalFilter = joinedCondition;
        }

        if(paramsMap.get("limite_inferior") != null){
            List<String> condicionesInferior = new ArrayList<>();
            for(String inferior: paramsMap.get("limite_inferior"))
                condicionesInferior.add("saldo>'" + inferior + "'");
            joinedCondition = String.join(" OR ", condicionesInferior);
            if (joinedCondition.length() > 0) {
                if (finalFilter.length() > 0)
                    finalFilter = String.format("(%s) AND (%s)", finalFilter, joinedCondition);
                else
                    finalFilter = joinedCondition;
            }
        }
        if(paramsMap.get("limite_superior") != null){
            List<String> condicionesSuperior = new ArrayList<>();
            for(String superior: paramsMap.get("limite_superior"))
                condicionesSuperior.add("saldo<'" + superior + "'");
            joinedCondition = String.join(" OR ", condicionesSuperior);
            if (joinedCondition.length() > 0) {
                if (finalFilter.length() > 0)
                    finalFilter = String.format("(%s) AND (%s)", finalFilter, joinedCondition);
                else
                    finalFilter = joinedCondition;
            }
        }

        return finalFilter;
    }
}
