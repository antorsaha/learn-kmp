# KMP & CMP learning checklist

Use this after Jetpack Compose / Android experience. Check items as you complete them.

## Kotlin Multiplatform (KMP) — foundation

- Understand `commonMain` vs platform source sets (`androidMain`, `jvmMain`, `iosMain`, …)
- Open and read your module’s `build.gradle.kts` / `libs.versions.toml` (targets + dependencies)
- Know what a **compilation target** is (Android, JVM/desktop, iOS, etc.)
- Write one `**expect` / `actual`** pair (e.g. small platform API or `BatteryManager`-style)
- Know when **not** to use expect/actual (prefer multiplatform libraries when they exist)
- Run **Android** and at least one **other target** (JVM desktop or iOS) from the same project                                                                                                               

## Shared code & architecture

- Move a **pure Kotlin** model or use case into `commonMain` (no Android imports)
- Define a **repository interface** in common; implement or wire I/O on each platform (or via library)
- Decide a **DI approach** (constructor injection, Koin, etc.) for `commonMain` + entry points

## Compose Multiplatform (CMP) — UI

- Build one **shared screen** in `commonMain` used by Android + another target
- Use `**remember` / state** the same way as Jetpack Compose; note any CMP-specific APIs
- Handle **resources** (Compose Multiplatform resources or your project’s pattern)
- Read **CMP release notes** when bumping versions (API drift vs Jetpack Compose)

## Android (your comfort zone — verify KMP wiring)

- Trace **entry point** → how `BatteryManager` (or similar) is constructed and passed into `App`
- Confirm **minSdk / dependencies** still make sense for shared module

## Desktop (JVM) — if you target it

- Run the **JVM** configuration and fix `JAVA_HOME` / JDK if the build fails
- Know that **some OS APIs** need JVM libraries or `expect`/`actual` (battery, paths, etc.)

## iOS — only if you target it

- Install **Xcode** and open the generated iOS project when troubleshooting
- Run the app on **simulator** from your IDE or Gradle task
- Skim **Kotlin/Native** + framework export basics (enough to unblock build errors)
- Optional: **CocoaPods** vs **SPM** setup as used by your template

## Networking & data (typical next step)

- Add **Ktor client** in `commonMain` for one HTTP call
- Persist something with **SQLDelight** or an explicit Android-only / expect-actual storage plan

## Polish & shipping mindset

- **Error handling** and loading states shared in UI where possible
- **CI**: at least compile all targets you ship (or document which are manual)

---

**Suggested order:** KMP source sets + Gradle → one shared Composable → expect/actual → Ktor → iOS or desktop depth as needed.