/* Public class TagImpl that implements the Tag interface.
 */
package Entities;
import EntityInterfaces.Tag;

public class TagImpl implements Tag {
    private String name;

    public TagImpl(String name) {
        this.name = name;
    }
    /* Implement a TagImpl, giving the name of the tag.
     * @param tag  The name of the tag
     */

    public String name() {
        return this.name;
    }
}
