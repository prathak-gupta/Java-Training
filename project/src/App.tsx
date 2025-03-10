import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import { AuthProvider, useAuth } from './context/AuthContext';
import LoginForm from './components/Auth/LoginForm';
import MainLayout from './components/Layout/MainLayout';
import DashboardRouter from './components/Dashboard/DashboardRouter';
import AppointmentCalendar from './components/Appointments/AppointmentCalendar';
import AppointmentForm from './components/Appointments/AppointmentForm';
import PatientRecords from './components/MedicalRecords/PatientRecords';
import PrescriptionList from './components/Prescriptions/PrescriptionList';
import BillingList from './components/Billing/BillingList';
import LabReportList from './components/LabReports/LabReportList';
import NotificationList from './components/Notifications/NotificationList';
import VitalsMonitor from './components/Vitals/VitalsMonitor';
import ViewAllDoctors from './components/ViewAll/ViewAllDoctors';

// Protected route component
const ProtectedRoute: React.FC<{ children: React.ReactNode }> = ({ children }) => {
  const { isAuthenticated, loading } = useAuth();
  
  if (loading) {
    return <div className="min-h-screen flex items-center justify-center">Loading...</div>;
  }
  
  if (!isAuthenticated) {
    return <Navigate to="/login" replace />;
  }
  
  return <>{children}</>;
};

function App() {
  return (
    <AuthProvider>
      <Router>
        <Routes>
          <Route path="/login" element={<LoginForm />} />
          
          <Route path="/" element={
            <ProtectedRoute>
              <MainLayout />
            </ProtectedRoute>
          }>
            <Route index element={<Navigate to="/dashboard" replace />} />
            <Route path="dashboard" element={<DashboardRouter />} />
            
            <Route path="appointments" element={<AppointmentCalendar />} />
            <Route path="appointments/new" element={<AppointmentForm />} />
            
            <Route path="medical-records" element={<PatientRecords />} />
            <Route path="prescriptions" element={<PrescriptionList />} />
            <Route path="billing" element={<BillingList />} />
            <Route path="lab-reports" element={<LabReportList />} />
            <Route path="notifications" element={<NotificationList />} />
            <Route path="vitals" element={<VitalsMonitor />} />
            <Route path="/doctors" element={<ViewAllDoctors/>} />
            
            {/* Add more routes as needed */}
            <Route path="*" element={<div>Page not found</div>} />
          </Route>
        </Routes>
      </Router>
    </AuthProvider>
  );
}

export default App;