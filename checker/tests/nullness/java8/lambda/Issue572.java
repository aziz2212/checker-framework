// @skip-test

// Test case for issue #572: https://github.com/typetools/checker-framework/issues/572

import java.util.function.BiFunction;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

class ParenthesizedLambda {
  static <A, B, C> C biApply(BiFunction<A, B, C> f, A a, B b) {
    return f.apply(a, b);
  }

  public <A, B> A konst(@NonNull A a, @Nullable B b) {
    return biApply(((first,second) -> first), a, b);
  }
}
