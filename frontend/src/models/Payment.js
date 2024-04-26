class Payment{
    constructor(id,amount,client,missed,dueDate)
    {
        this.id=id;
        this.amount=amount;
        this.client=client;
        this.missed=missed;
        this.dueDate=dueDate;
    }
}
export default Payment;