
export default class Producto {

    constructor(fields) {

        this.id = fields.id || 0;
        this.nombre = fields.nombre || "";
        this.cantidad = fields.cantidad || 0;
        this.precio = fields.precio || 0;
        this.vendedor = fields.vendedor || "";
        this.detalles = fields.detalles || "";
        this.imagen = fields.imagen || "https://i.pinimg.com/originals/ec/a3/2e/eca32ee5c3c2c768704a7198d60b867d.jpg";
        if (fields.caducidad) {
            this.caducidad = new Date(fields.caducidad)
        } else {
            this.caducidad = new Date();
        }
    }
}

export const Validate = (p) => {
    return isNumber(p.id) && isNumber(p.cantidad) && isNumber(p.precio)
            && isText(p.nombre) && isText(p.detalles) && isText(p.vendedor) 
            && isText(p.imagen) && p.caducidad.toISOString !== undefined;
    }

const isNumber = n => undefined !== n && (typeof n === 'number' || !isNaN(Number.parseFloat(n)));
const isText   = t => undefined !== t && (typeof t === 'string' && t.trim().length > 0);