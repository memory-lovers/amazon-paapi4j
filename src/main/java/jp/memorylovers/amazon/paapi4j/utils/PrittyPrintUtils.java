package jp.memorylovers.amazon.paapi4j.utils;

import java.lang.reflect.Field;
import java.util.List;

public class PrittyPrintUtils {
    private StringBuilder sb = new StringBuilder();
    private boolean visibleNull = false;

    public String prittyPrint(Object root) {
        return prittyPrint(0, null, root);
    }

    private String prittyPrint(int indent, String fieldName, Object obj) {
        String className = obj.getClass().getSimpleName();

        if (fieldName == null) {
            appendLn(indent, className + " { ");
        } else {
            appendLn(indent, fieldName + " = " + className + " { ");
        }


        indent++;
        Field[] fields = obj.getClass().getFields();
        for (Field field : fields) {
            try {
                if(field.getType() == Integer.class || field.getType() == int.class) {
                    appendField(indent, field.getName(), field.get(obj));
                } else if(field.getType() == String.class) {
                    appendField(indent, field.getName(), field.get(obj));
                } else if(field.getType() == Boolean.class || field.getType() == boolean.class) {
                    appendField(indent, field.getName(), field.get(obj));
                } else if(field.getType() == List.class) {
                    Object child = field.get(obj);
                    if (child == null) {
                        appendField(indent, field.getName(), child);
                    } else {
                        List list = (List) child;
                        appendLn(indent, field.getName() + " = [ ");
                        for (Object c : list) {
                            prittyPrint(indent + 1, null, c);
                        }
                        appendLn(indent, "]");
                    }
                } else {
                    Object child = field.get(obj);
                    if (child == null) {
                        appendField(indent, field.getName(), child);
                    } else {
                        prittyPrint(indent, field.getName(), field.get(obj));
                    }
                }

            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        indent--;
        appendLn(indent, "}");
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
            value = obj.toString().trim();
        }

        if (visibleNull || (!visibleNull && obj != null)) {
            appendLn(indent, key + " = " + value);
        }
    }
}
