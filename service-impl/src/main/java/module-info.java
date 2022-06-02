module service.impl {
    requires service.op;

    provides operation.Operation with multi.Multiply;
}