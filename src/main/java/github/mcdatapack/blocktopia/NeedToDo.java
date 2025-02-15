package github.mcdatapack.blocktopia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.*;

@SuppressWarnings("unused")
public class NeedToDo {
    public static final Task TEXTURES_OF_BANANA_WOOD = new Task(3.0, 1, TaskStatus.DONE);
    public static final Task STRIPPING_OF_LOGS = new Task(3.0, 0, TaskStatus.DONE);
    public static final Task NETHERITE_CHERRIES = new Task(3.0, 0, TaskStatus.DONE);
    public static final Task DIAMOND_AND_NETHERITE_COCONUTS = new Task(3.0, 0, TaskStatus.NOT_STARTED);
    public static final Task MONKEY_WALK_ANIMATION_FIX = new Task(3.0, 0, TaskStatus.NOT_STARTED);
    public static final Task MONKEY_HEAD_LOOKAROUND_FIX = new Task(3.0, 0, TaskStatus.NOT_STARTED);
    public static final Task BETTER_TALE_ANIMATIONS = new Task(3.0, 0, TaskStatus.NOT_STARTED);
    public static final Task JUNGLE_TREE_IN_RAIN_FOREST_FIX = new Task(3.0, 0, TaskStatus.DONE);
    public static final Task RAIN_FOREST_TRANSLATION = new Task(3.0, 0, TaskStatus.DONE);
    public static final Task BANANA = new Task(3.0, 0, TaskStatus.DONE);
    public static final Task RAIN_FOREST_STRUCTURES = new Task(3.0, 1, TaskStatus.DONE);
    public static final Task LEGACY_FURNACE_ROTATION = new Task(3.0, 0, TaskStatus.NOT_STARTED);

    public enum TaskStatus {
        NOT_STARTED,
        IN_PROGRESS,
        DONE
    }
    public record Task(double version, int author, TaskStatus status) {}

    public static Map<TaskStatus, List<String>> countTasks() {
        Field[] fields = Arrays.stream(NeedToDo.class.getDeclaredFields())
                .filter(field -> field.getType() == NeedToDo.Task.class)
                .toArray(Field[]::new);

        Map<TaskStatus, List<String>> taskMap = new EnumMap<>(TaskStatus.class);
        taskMap.put(TaskStatus.NOT_STARTED, new ArrayList<>());
        taskMap.put(TaskStatus.IN_PROGRESS, new ArrayList<>());
        taskMap.put(TaskStatus.DONE, new ArrayList<>());

        for (Field field : fields) {
            try {
                Task task = (Task) field.get(null);
                String taskName = field.getName();
                taskMap.get(task.status()).add(taskName);
            } catch (IllegalAccessException ignored) {}
        }

        return taskMap;
    }

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("TODO");
        Map<TaskStatus, List<String>> taskMap = countTasks();

        taskMap.forEach((status, tasks) -> logger.info("{}: {} ({})", status, tasks.size(), String.join(", \n                              ", tasks)));
    }
}
