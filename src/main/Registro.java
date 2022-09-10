package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.SimpleTimeZone;

public class Registro {

    private ArrayList<Usuario> usuarios;
    private Gson gson;

    public Registro(){
        usuarios = new ArrayList<>();
        gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(Usuario.class, new UserTypeAdapter()).create();
    }

    public void cargarUsuarios(){
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream("./test.json"), StandardCharsets.UTF_8);
            usuarios = gson.fromJson(reader, new TypeToken<ArrayList<Usuario>>(){}.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void registrarUsuario(Usuario usuario){
        usuarios.add(usuario);
        try(OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("./test.json"), StandardCharsets.UTF_8)) {
            writer.write(gson.toJson(usuarios));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario buscarUsuario(String id, String contrasenia){
        for(Usuario usuario: usuarios){
            if(usuario.getId().equals(id) && usuario.getContrasenia().equals(contrasenia)){
                return usuario;
            }
        }
        return null;
    }



    public static void main(String[] args) {


        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(Usuario.class, new UserTypeAdapter()).create();
            InputStreamReader reader = new InputStreamReader(new FileInputStream("./test.json"), StandardCharsets.UTF_8);
            ArrayList<Usuario> list2 = gson.fromJson(reader, new TypeToken<ArrayList<Usuario>>(){}.getType());
            System.out.println(list2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }




        /*
        Usuario user = new Usuario(
                "Pepe",
                25,
                65.25,
                1.65,
                'M',
                "pepe1",
                "1234"
        );

        Usuario user2 = new Usuario(
                "Pepe",
                25,
                65.25,
                1.65,
                'M',
                "pepe1",
                "1234"
        );

        ArrayList<Usuario> list = new ArrayList<>();
        list.add(user);
        list.add(user2);

        String json = gson.toJson(list);
        System.out.println(json);

        String readJson = "[\n" +
                "  {\n" +
                "    \"id\": \"pepe1\",\n" +
                "    \"contrasenia\": \"1234\",\n" +
                "    \"name\": \"Pepe\",\n" +
                "    \"edad\": 25,\n" +
                "    \"peso\": 65.25,\n" +
                "    \"altura\": 1.65,\n" +
                "    \"sexo\": \"M\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"pepe1\",\n" +
                "    \"contrasenia\": \"1234\",\n" +
                "    \"name\": \"Pepe\",\n" +
                "    \"edad\": 25,\n" +
                "    \"peso\": 65.25,\n" +
                "    \"altura\": 1.65,\n" +
                "    \"sexo\": \"M\"\n" +
                "  }\n" +
                "]\n" +
                "\n";


        ArrayList<Usuario> list2 = gson.fromJson(readJson, new TypeToken<ArrayList<Usuario>>(){}.getType());
        System.out.println(list2);
*/




    }



}

class UserTypeAdapter extends TypeAdapter<Usuario> {

    @Override
    public void write(JsonWriter jsonWriter, Usuario usuario) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("id").value(usuario.getId());
        jsonWriter.name("contrasenia").value(usuario.getContrasenia());
        jsonWriter.name("name").value(usuario.getName());
        jsonWriter.name("edad").value(usuario.getEdad());
        jsonWriter.name("peso").value(usuario.getPeso());
        jsonWriter.name("altura").value(usuario.getAltura());
        jsonWriter.name("sexo").value(String.valueOf(usuario.getSexo()));
        jsonWriter.endObject();
    }

    @Override
    public Usuario read(JsonReader jsonReader) throws IOException {
        String nombre = "";
        String id = "";
        String contrasenia = "";
        double peso = 0.0;
        double altura = 0.0;
        int edad = 0;
        char sexo = ' ';
        jsonReader.beginObject();
        while (jsonReader.hasNext()){
            String name = jsonReader.nextName();
            switch (name){
                case "id":
                    id = jsonReader.nextString();
                    break;
                case "contrasenia":
                    contrasenia = jsonReader.nextString();
                    break;
                case "name":
                    nombre = jsonReader.nextString();
                    break;
                case "edad":
                    edad = jsonReader.nextInt();
                    break;
                case "peso":
                    peso = jsonReader.nextDouble();
                    break;
                case "altura":
                    altura = jsonReader.nextDouble();
                    break;
                case "sexo":
                    sexo = jsonReader.nextString().charAt(0);
                    break;
                default:
                    jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new Usuario(
                nombre,
                edad,
                peso,
                altura,
                sexo,
                id,
                contrasenia
        );
    }
}
