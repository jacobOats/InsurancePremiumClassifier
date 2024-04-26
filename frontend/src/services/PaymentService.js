// services/ClientService.js
import axios from 'axios';
class PaymentService {
  constructor() {
    this.employees = [];
  }

  addPayment(payment) {
      return axios.post('http://localhost:8080/api/payments/payment', payment)
            .then(response => response.data)
            .catch(error => {
                console.error('Error adding Payment:', error);
                throw error; // Propagate error to caller
            });
  }

  getPaymentById(id) {
    return axios.get(`http://localhost:8080/api/payments/payment/${id}`)
        .then(response => response.data)
        .catch(error => {
            console.error('Error fetching payment by ID:', error);
            throw error; // Propagate error to caller
        });
}

  getAllPayments() {
    return axios.get('http://localhost:8080/api/payments/payment')
        .then(response => response.data)
        .catch(error => {
            console.error('Error fetching Payment:', error);
            throw error; // Propagate error to caller
        });
}
}

export default PaymentService;
