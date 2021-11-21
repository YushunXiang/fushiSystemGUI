package formatterSettings;

import studentCatalog.StudentCatalog;

/**
 * Desc: A public interface
 * @see StudentCatalog
 * @return {@link null}
 * @author Yushun Xiang
 * @date 2021/11/8 16:07
 */
public interface StudentsFormatter {
    public String formatStudents(StudentCatalog studentCatalog);
}
