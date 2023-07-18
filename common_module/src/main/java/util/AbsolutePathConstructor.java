package util;

import java.io.File;

/*
* Утилита для определения абсолютного пути к файлу (решение в связи с особенностями компиляции модулей)
 */

public class AbsolutePathConstructor {

    public static String defineAbsolutePath(String pathFromRepositoryRoot) {
        File fileInCompiledModuleRoot = new File("");
        String absolutePathToCompiledModule = fileInCompiledModuleRoot.getAbsolutePath();
        String absolutePathToRepositoryRoot = absolutePathToCompiledModule.substring(0, absolutePathToCompiledModule.lastIndexOf(File.separator));
        pathFromRepositoryRoot = pathFromRepositoryRoot.replace("/", File.separator);
        return String.format("%s%s%s", absolutePathToRepositoryRoot, File.separator, pathFromRepositoryRoot);
    }
}