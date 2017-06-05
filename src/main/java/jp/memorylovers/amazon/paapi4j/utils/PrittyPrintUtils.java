package jp.memorylovers.amazon.paapi4j.utils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class PrittyPrintUtils {
    private StringBuilder sb = new StringBuilder();
    private boolean visibleNull = true;

    public static String pp(Object root) {
        return new PrittyPrintUtils().prittyPrint(root);
    }

    public String prittyPrint(Object root) {
        return prittyPrint(0, null, root);
    }

    @SuppressWarnings("unchecked")
    private String prittyPrint(int indent, String fieldName, Object obj) {

        if (obj instanceof List) {
            if (((List<Object>) obj).size() > 0) {
                appendLn(indent, "[ ");
                for (Object c : (List<Object>) obj) {
                    prittyPrint(indent + 1, null, c);
                }
                appendLn(indent, "]");
            } else {
                appendLn(indent, "[]");
            }
        } else {
            if (obj != null && obj.getClass() != null && !obj.getClass()
                .getName()
                .startsWith("java")) {

                String className = obj.getClass()
                    .getSimpleName();
                //System.out.println("class name is " + className);
                if (fieldName == null) {
                    appendLn(indent, className + " { ");
                } else {
                    appendLn(indent, fieldName + " = " + className + " { ");
                }

                indent++;
                Field[] fields = obj.getClass()
                    .getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    //System.out.println("field name is " + field.getName());
                    try {
                        if (field.getType() == Integer.class || field
                            .getType() == int.class) {
                            appendField(
                                indent, field.getName(), field.get(obj));
                        } else if (field.getType() == String.class) {
                            appendField(
                                indent, field.getName(), field.get(obj));
                        } else if (field.getType() == Boolean.class || field
                            .getType() == boolean.class) {
                            appendField(
                                indent, field.getName(), field.get(obj));
                        } else if (field.getType() == List.class) {
                            Object child = field.get(obj);

                            if (child == null) {
                                appendField(indent, field.getName(), child);
                            }else if (field.getGenericType() instanceof ParameterizedType && ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0].getTypeName().startsWith("java.util.List")) {
                                ParameterizedType type = (ParameterizedType) field.getGenericType();
                                //System.out.println("generic type is " + field.getGenericType().getTypeName() + " " + type.getActualTypeArguments()[0].getTypeName());
                                String[] vals = ((List<Object>) child).stream()
                                        .map(Object::toString)
                                        .toArray(String[]::new);
                                    appendLn(indent, "[ " + String.join(", ", vals) + "]");
                            } else {
                                @SuppressWarnings("unchecked")
                                List<Object> list = (List<Object>) child;
                                if (list.size() > 0) {
                                    appendLn(indent, field.getName() + " = [ ");
                                    for (Object c : list) {
                                        prittyPrint(indent + 1, null, c);
                                    }
                                    appendLn(indent, "]");
                                } else {
                                    appendLn(indent, field.getName() + " = []");
                                }
                            }
                        } else {
                            Object child = field.get(obj);
                            if (child == null) {
                                appendField(indent, field.getName(), child);
                            } else {
                                prittyPrint(
                                    indent, field.getName(), field.get(obj));
                            }
                        }

                    } catch (IllegalArgumentException
                            | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }

                indent--;
                appendLn(indent, "}");
            }
        }
        return sb.toString();
    }

    private void appendLn(int indent, String contents) {
        String str = "";
        for (int i = 0; i < indent; i++) {
            str += "  ";
        }

        sb.append(str + contents + "\n");
    }

    private void appendField(int indent, String key, Object obj) {
        String value;

        if (obj == null) {
            value = "<null>";
        } else {
            value = obj.toString()
                .trim();
        }

        if (visibleNull || (!visibleNull && obj != null)) {
            appendLn(indent, key + " = " + value);
        }
    }
}
