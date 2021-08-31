package com.basictest.annotation.apt;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.FieldDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;

import java.io.*;

/**
 * Created in 2021/4/8 9:14
 * 根据注释生成一个hibernate映射文件(xml)
 * @author: huxingxin
 */
public class HibernateAnnotationProcessor implements AnnotationProcessor {

    private AnnotationProcessorEnvironment env;

    public HibernateAnnotationProcessor(AnnotationProcessorEnvironment env){
        this.env = env;
    }

    @Override
    public void process() {
        for(TypeDeclaration t : env.getSpecifiedTypeDeclarations()){
            FileOutputStream fos = null;
            String className = t.getSimpleName();
            Persistent persistent = t.getAnnotation(Persistent.class);
            if(persistent != null){
                try {
                    fos = new FileOutputStream(className+"hbm.xml");
                    PrintStream printStream = new PrintStream(fos);
                    printStream.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                    printStream.println("<!DOCTYPE hibernate-mapping PUBLIC");
                    printStream.println("\"-//Hibernate/Hibernate Mapping DTD 3.0//EN\"");
                    printStream.println("\"http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd\"");
                    printStream.println("<hibernate-mapping>");
                    printStream.println("<class name=\"" + t +"\" table=\"" + persistent.table() + "\">");

                    for(FieldDeclaration f  : t.getFields()){
                        IdProperty idProperty = f.getAnnotation(IdProperty.class);
                        if(idProperty != null){
                            printStream.println(" <id name=\"" + f.getSimpleName() + "\" type=\""+idProperty.type()+"\">\n" +
                                    "            <column name=\"" + idProperty.column() + "\"/>\n" +
                                    "            <generator class=\"" + idProperty.generator() + "\"/>\n" +
                                    "        </id>");
                        }
                        Property property = f.getAnnotation(Property.class);
                        if(property != null){
                            printStream.println("<property name=\"" + f.getSimpleName()+"\" type=\"" + property.type() + "\">\n" +
                                    "            <column name=\"" + property.column() + "\"/>\n" +
                                    "        </property>");
                        }
                    }
                    printStream.println("</class>");
                    printStream.println("</hibernate-mapping>");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }finally {
                    if (fos != null){
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }
}
