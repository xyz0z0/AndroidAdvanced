package xyz.xyz0z0.javapoetlib;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import java.io.IOException;
import javax.lang.model.element.Modifier;

/**
 * @author Cheng
 */
public class MainTest {

    public static void main(String[] args) {
        try {
            // generateHelloWorld();
            // generateForTest();
            // computeRange("multi", 10, 20, "*");
            // caseTest();

            // classNameTest1();
            // classNameTest2();
            // nonBodyTest();
            constructorTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void constructorTest() {
        MethodSpec flux = MethodSpec.constructorBuilder()
            .addModifiers(Modifier.PUBLIC)
            .addParameter(String.class, "greeting")
            .addStatement("this.$N = $N", "greeting", "greeting")
            .build();
        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
            .addModifiers(Modifier.PUBLIC)
            .addField(String.class, "greeting", Modifier.PRIVATE, Modifier.FINAL)
            .addMethod(flux)
            .build();
        System.out.println(helloWorld.toString());
    }


    private static void nonBodyTest() {
        MethodSpec flux = MethodSpec.methodBuilder("flux")
            // .returns(String.class)
            .addModifiers(Modifier.ABSTRACT, Modifier.PROTECTED)
            .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
            .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
            .addMethod(flux)
            .build();
        System.out.println(helloWorld.toString());
    }


    private static void classNameTest2() {
        ClassName hoverboard = ClassName.get("com.mattel", "Hoverboard");
        ClassName list = ClassName.get("java.util", "List");
        ClassName arrayList = ClassName.get("java.util", "ArrayList");
        TypeName listOfHoverboards = ParameterizedTypeName.get(list, hoverboard);

        MethodSpec beyond = MethodSpec.methodBuilder("beyond")
            .returns(listOfHoverboards)
            .addStatement("$T result = new $T<>()", listOfHoverboards, arrayList)
            .addStatement("result.add(new $T())", hoverboard)
            .addStatement("result.add(new $T())", hoverboard)
            .addStatement("result.add(new $T())", hoverboard)
            .addStatement("return result")
            .build();
        System.out.println(beyond.toString());
    }


    private static void classNameTest1() {
        ClassName hoverboard = ClassName.get("com.mattel", "Hoverboard");
        MethodSpec today = MethodSpec.methodBuilder("tomorrow")
            .returns(hoverboard)
            .addStatement("return new $T()", hoverboard)
            .build();
        System.out.println(today.toString());
    }


    private static void caseTest() {
        MethodSpec main = MethodSpec.methodBuilder("main")
            .addStatement("long now = $T.currentTimeMills()", System.class)
            .beginControlFlow("if ($T.currentTimeMillis()<now)", System.class)
            .addStatement("$T.out.println($S)", System.class, "Time travelling,woo hoo!")
            .nextControlFlow("else if($T.currentTimeMillis() == now)", System.class)
            .addStatement("$T.out.println($S)", System.class, "Time stood still!")
            .nextControlFlow("else")
            .addStatement("$T.out.println($S)", System.class, "Ok,time still moving forward")
            .endControlFlow()
            .build();
        System.out.println(main.toString());
    }


    private static void computeRange(String name, int from, int to, String op) {
        MethodSpec main = MethodSpec.methodBuilder(name)
            .returns(int.class)
            .addStatement("int result = 1")
            .beginControlFlow("for (int i =" + from + ";i<" + to + ";i++")
            .addStatement("result = result" + op + "i")
            .endControlFlow()
            .addStatement("return result")
            .build();
        System.out.println(main.toString());

    }


    private static void generateForTest() {
        MethodSpec main1 = MethodSpec.methodBuilder("main")
            .addCode(""
                + "int total = 0;\n"
                + "for (int i = 0 ;i<10;i++){\n"
                + " total += i;\n"
                + "}\n")
            .build();
        System.out.println(main1.toString());

        MethodSpec main2 = MethodSpec.methodBuilder("main")
            .addStatement("int total = 0")
            .beginControlFlow("for (int i=0;i<10;i++")
            .addStatement("total += i")
            .endControlFlow()
            .build();
        System.out.println(main2.toString());
    }


    public static void generateHelloWorld() throws IOException {
        MethodSpec main = MethodSpec.methodBuilder("main")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .returns(void.class)
            .addParameter(String[].class, "args")
            .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
            .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
            .addMethod(main)
            .build();

        JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
            .build();
        javaFile.writeTo(System.out);
    }

}