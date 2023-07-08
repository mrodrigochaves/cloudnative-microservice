
package com.mrodrigochaves.services;


import java.util.ArrayList;
import java.util.List;

import com.mrodrigochaves.Block;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/blocks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BlockService {
    private List<Block> blockchain = new ArrayList<>();

    @GET
    public List<Block> getAllBlocks() {
        return blockchain;
    }

    @POST
    public Block createBlock(Block block) {
        
        block.setHash(block.calculateBlockHash());

        
        blockchain.add(block);

        return block;
    }

    @PUT
    @Path("/{index}")
    public Block updateBlock(@PathParam("index") int index, Block updatedBlock) {
        if (index >= 0 && index < blockchain.size()) {
            Block block = blockchain.get(index);

            
            block.setData(updatedBlock.getData());

            
            block.setHash(block.calculateBlockHash());

            return block;
        } else {
            throw new NotFoundException("Block not found");
        }
    }

    @DELETE
    @Path("/{index}")
    public void deleteBlock(@PathParam("index") int index) {
        if (index >= 0 && index < blockchain.size()) {
            blockchain.remove(index);
        } else {
            throw new NotFoundException("Block not found");
        }
    }
}
