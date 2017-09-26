// EXPECTED_REACHABLE_NODES: 1099
private inline fun typeOf(x: dynamic): String = js("typeof x").unsafeCast<String>()

fun box(): String {
    val arr = charArrayOf('A')

    var r = typeOf(arr.iterator().asDynamic().nextChar())
    if (r != "number") return "fail1: $r"

    var progression = 'A'..'Z'
    r = typeOf(progression.asDynamic().first)
    if (r != "number") return "fail2: $r"
    r = typeOf(progression.asDynamic().last)
    if (r != "number") return "fail3: $r"

    r = typeOf(Char.asDynamic().MIN_HIGH_SURROGATE)
    if (r != "number") return "fail4: $r"

    return "OK"
}

fun getInt() = 65