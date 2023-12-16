
package presentacion;

/**
 *
 * @author isais
 */
public class ComboBoxItem {
    public String key;
    public String value;

    public ComboBoxItem(String k, String v) {
        this.key = k;
        this.value = v;
    }

    @Override
    public String toString() {
        return value; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
