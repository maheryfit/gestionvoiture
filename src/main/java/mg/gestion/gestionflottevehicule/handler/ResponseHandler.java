package mg.gestion.gestionflottevehicule.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static void showError(HttpServletResponse response, Exception exception, HttpStatus
                                  httpStatus) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Error", exception.getMessage());
        map.put("Status", httpStatus.value());
        String toSend = mapper.writeValueAsString(map);
        response.setContentType("application/json");
        response.getWriter().write(toSend);
    }

    public static String generateResponse(String message, HttpStatus st, Object responseobj) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Message", message);
        map.put("Status", st.value());
        if (responseobj != null)
            map.put("Data", responseobj);
        return getString(map);
    }

    public static String generateErrorResponse(String message, HttpStatus st) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Error", message);
        map.put("Status", st.value());
        return getString(map);
    }

    public static String sendResponseData(Object object, HttpStatus st) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Data", object);
        map.put("Status", st.value());
        return getString(map);
    }

    public static String getString(Map<String, Object> map) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(map);
    }
}
