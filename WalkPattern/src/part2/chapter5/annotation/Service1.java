package part2.chapter5.annotation;

import com.google.inject.ImplementedBy;

/**
 * Date: Nov 19, 2010
 * Time: 4:33:34 PM
 *|| */
@ImplementedBy(Service1Impl.class)
public interface Service1 {
    void execute();
}