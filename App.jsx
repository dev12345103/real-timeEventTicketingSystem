import React from "react";
import { ChakraProvider } from "@chakra-ui/react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import { WebSocketProvider } from "./contexts/WebSocketContext";
import Navbar from "./components/Layout/NavBar";
import TicketPurchase from "./components/Tickets/TicketPurchase";
import SystemSettings from "./components/Settings/SystemSettings";

const queryClient = new QueryClient();

function App() {
  return (
    <ChakraProvider>
      <QueryClientProvider client={queryClient}>
        <WebSocketProvider>
          <Router>
            <Navbar />
            <Routes>
              <Route path="/" element={<TicketPurchase />} />
              <Route path="/tickets" element={<TicketPurchase />} />
              <Route path="/settings" element={<SystemSettings />} />
            </Routes>
          </Router>
        </WebSocketProvider>
      </QueryClientProvider>
    </ChakraProvider>
  );
}

export default App;
